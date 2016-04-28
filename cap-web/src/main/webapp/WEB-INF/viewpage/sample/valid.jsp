<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="none">
<title>ValidationEngine</title>
</head>
<body>
    <script>
          loadScript('js/sample/valid');
        </script>
    <h1>ValidationEngine Demo</h1>
    <br />
    <form onsubmit="return false;">
        <div>
            <div>
                <span>My name</span> <input id="myName" name="myName" class="validate[required, funcCall[_minSize[10]]]" type="text" />
            </div>
            <br />
            <div>
                <span> My phone <br /> number
                </span> <input id="phoneNo" name="phoneNo" class="mine validate[funcCall[regex[myCustValid]]]" type="text" />
            </div>
            <div>
                <button id="check">check</button>
            </div>
        </div>
    </form>
</body>
</html>
