<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>expand.html</title>
    <link type="text/css" href="css/default.css" rel="Stylesheet"/>
    <script type="text/javascript" src="scripts/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="scripts/messagecenter.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#maximizePanel').click(function () {
                $(this).removeClass('maximizePanelOver');
                $axure.messageCenter.postMessage('expandFrame');
            });
            $('#maximizePanel').mouseenter(function () {
                $(this).addClass('maximizePanelOver');
            });
            $('#maximizePanel').mouseout(function () {
                $(this).removeClass('maximizePanelOver');
            });
        });


        var x=1;
        var y=0;
        var z=0;
        function add(n){
            n=n+1;
            alert(n)
        }
        y=add(x);
        alert(y);
        function add(n){n=n+3;}
        z=add(x);
        alert(z);
    </script>





</head>
<body style="background-color:transparent;">
    <div id="maximizePanel" class="maximizePanel">
    </div>


</body>
</html>