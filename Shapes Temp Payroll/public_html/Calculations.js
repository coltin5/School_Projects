/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class circle {
 constructor(radius){
     this.radius = radius;
     
     this.perimeter = Math.PI * 2 * radius;
     
     this.area = Math.PI * radius * radius;
 }
 }
 function display(){
     let cir = new circle(document.getElementById('radius').value);
     document.getElementById('p1').innerHTML = "Area :" + cir.area
     document.getElementById('p2').innerHTML = "Circumference: " + cir.perimeter;
 }
class rectangle{
    constructor(l,w){
        this.width = w;
        
        this.length = l;
        
        this.perimeter = (parseInt(l) + parseInt(w)) * 2;
        
        this.area = l * w;
    }
}
function displayRec(){
    
   let rec = new rectangle(document.getElementById('length').value, document.getElementById('width').value)

   document.getElementById('p3').innerHTML = "Area :" + rec.area;
   document.getElementById('p4').innerHTML = "Perimeter: " + rec.perimeter;

}
class tempConverter{
    constructor(temp){
        this.temp = temp;
        this.convert = temp * (9/5) + parseInt(32);
        this.convert2 = (temp - 32) * 5/9;
    }
}
function convert(){
    let temp1 = new tempConverter(document.getElementById('temp').value);
    document.getElementById('p5').innerHTML = "Degrees Fahrenheit: " + temp1.convert;
}
function convert2(){
    let temp2 = new tempConverter(document.getElementById('temp').value);
    document.getElementById('p6').innerHTML = "Degrees Fahrenheit: " + temp2.convert2;
}
function pay(){
    let hours = document.getElementById('hours').value;
    let wage = document.getElementById('wage').value;
    var pay1;
    var pay2;
    if(hours > 40){
        var ot = hours - 40;
        pay1 = (wage * 1.5) * ot + wage * 40;
        document.getElementById('p7').innerHTML = "Compensation: $" + pay1;
    }
    else{
        document.getElementById('p7').innerHTML = "Compensation: $" + (hours * wage);
    }
}

function setAppAreaBounds(){ if(document.all){
 aWidth = document.body.clientWidth;
 aHeight = document.body.clientHeight; 
 }
 else{
 aWidth = innerWidth;
 aHeight = innerHeight; 
 }
 aWidth -= 30;
 aHeight -= 95;
 document.getElementById("appArea").style.width = aWidth + 'px'; document.getElementById("gameArea").style.height = aHeight + 'px'; aWidth -= 74;
 aHeight -= 74;
 }