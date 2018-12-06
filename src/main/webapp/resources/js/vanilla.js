/*
//fadeOut
var s = document.getElementById('thing').style;
s.opacity = 1;
(function fade(){(s.opacity-=.1)<0?s.display="none":setTimeout(fade,40)})();

//ajax Call
var r = new XMLHttpRequest();
r.open("POST", "path/to/api", true);
r.onreadystatechange = function () {
  if (r.readyState != 4 || r.status != 200) return;
  alert("Success: " + r.responseText);
};
r.send("banana=yellow");









*/