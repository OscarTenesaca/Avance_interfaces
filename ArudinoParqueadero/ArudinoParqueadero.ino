#include <Servo.h>
Servo Servo2;
Servo Servo1;



void setup() {
Serial.begin(9600);
Servo2.attach(7);
Servo1.attach(9);
   Servo1.write(75);
   Servo2.write(0);
}

void loop() {

if(Serial.available()>0){
  
  
  int t= Serial.read();
  if(t==1){
    
   Servo2.write(90);
   delay(5000);
   
   Servo2.write(0);

  }
  

  if(t==2){
    
   Servo1.write(180);
   delay(5000);
   Servo1.write(75);
   
   }
  }
}
