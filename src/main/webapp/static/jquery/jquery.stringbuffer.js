/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/7/19
 * Time: 15:19
 */
function StringBuffer(){
  this.__string__ = new Array();
}

StringBuffer.prototype.append = function(str){
  this.__string__.push(str);
  return this;
};

StringBuffer.prototype.toString = function(){
  return this.__string__.join("");
};