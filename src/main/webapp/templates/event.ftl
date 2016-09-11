<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    </head>
    <body>
       <div class="container-fluid">
       <div class="row-fluid">
               <h1> Hello ${user.name!""}! </h1>
           </div>
           <div class="row-fluid">
               As an EPAM'er you are invited to great new event "${event.name}"!

               It will be held in ${event.location} at ${event.date}.

               Brief description of an event:
               <p> ${event.description} </p>

               And there will be many interesting actions specially for you:
               <#list event.actions as action>
                <img src="/img/actions/${action.actionId}.jpg"/>
                <p> ${action.actionName} </p>
                <p> ${action.actionDescription} </p>
               </#list>

               <strong>We are waiting for you, ${user.name}!</strong>
           </div>
       </div>
    </body>
</html>