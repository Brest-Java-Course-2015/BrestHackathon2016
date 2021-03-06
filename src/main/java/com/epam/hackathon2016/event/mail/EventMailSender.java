package com.epam.hackathon2016.event.mail;

import com.epam.hackathon2016.event.domain.Event;
import com.epam.hackathon2016.event.domain.Group;
import com.epam.hackathon2016.event.domain.Survey;
import com.epam.hackathon2016.event.domain.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by alexander on 11.9.16.
 */
@Component
public class EventMailSender {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private Configuration freeMarkerConfig;

    public boolean sendEventCreationEmail(Event event) {

        List<User> userList = new ArrayList<>();
        for (Group group: event.getGroups()) {
            userList.addAll(group.getUserList().stream().collect(Collectors.toList()));
        }
        userList.stream().forEach(user -> {
            try {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

                helper.setTo(user.getEmail());
                helper.setSubject("Dear, " + user.getName() + "! New EPAM event is coming! Get involved!!!");
                helper.setText(prepareMailText(event, "event", user), true);
                mailSender.send(mimeMessage);

            } catch (MessagingException | TemplateException | IOException e) {
                System.out.println("Email to user: " + user.getName() + " was not sent!");
                e.printStackTrace();
            }
        });

        return true;
    }

    public boolean sendSurveyEmail(Survey survey) {
        Event event = survey.getEvent();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        List<User> userList = new ArrayList<>();
        for (Group group: event.getGroups()) {
            userList.addAll(group.getUserList().stream().collect(Collectors.toList()));
        }
        userList.stream().forEach(user -> {
            try {
                helper.setTo(user.getEmail());
                helper.setSubject("Dear, " + user.getName() + "! EPAM event is over. And we are waiting for your feedback!!!");
                helper.setText(prepareMailText(event, "survey", user), true);
                mailSender.send(mimeMessage);

            } catch (MessagingException | TemplateException | IOException e) {
                System.out.println("Email to user: " + user.getName() + " was not sent!");
                e.printStackTrace();
            }
        });

        return true;
    }

    private String[] getSendTo(Event event) {
        List<Group> groupList = event.getGroups();
        List<User> userList = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        for (Group group: groupList) {
            userList.addAll(group.getUserList().stream().collect(Collectors.toList()));
        }
        emails.addAll(userList.stream().map(User::getEmail).collect(Collectors.toList()));
        return (String[]) emails.toArray();
    }

    private String prepareMailText(Event event, String topic, User user) throws IOException, TemplateException {
        StringWriter message = new StringWriter();

        Template template = freeMarkerConfig.getTemplate(topic + ".ftl");
        Map<String, Object> model = new HashMap<>();
        model.put("event", event);
        model.put("user", user);
        template.process(model, message);

        return message.toString();
    }
}
