function (key,values) {
  var x = 0;
  values.forEach(function(v){x += v});
  return x;
}