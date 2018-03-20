#include <SoftwareSerial.h>

SoftwareSerial myserial (10, 11);

void setup ()
{
  Serial.begin (9600);
  myserial.begin (9600);
}

void loop ()
{
  int bendsensor1, bendsensor2, x1, y1, x2, y2;
  double gx1, gy1, gx2, gy2;
  double g1, g2;
  x1 = analogRead (A0);
  y1 = analogRead (A1);
  bendsensor1 = analogRead (A2);
  x2 = analogRead (A3);
  y2 = analogRead (A4);
  bendsensor2 = analogRead (A5);
  gx1 = 2/((615 - 394) * 1.0) * (x1 - 394) - 1;
  gy1 = 2/((625 - 386) * 1.0) * (y1 - 386) - 1;
  gx2 = 2/((615 - 394) * 1.0) * (x2 - 394) - 1;
  gy2 = 2/((625 - 386) * 1.0) * (y2 - 386) - 1;
  g1 = sqrt (gx1 * gx1 + gy1 * gy1);
  g2 = sqrt (gx2 * gx2 + gy2 * gy2);
  Serial.print (bendsensor1);
  Serial.print (" ");
  Serial.print (bendsensor2);
  Serial.print (" ");
  Serial.print (g1);
  Serial.print (" ");
  Serial.print (g2);
  Serial.println ();
  myserial.print (bendsensor1);
  myserial.print (" ");
  myserial.print (bendsensor2);
  myserial.print (" ");
  myserial.print (g1);
  myserial.print (" ");
  myserial.print (g2);
  myserial.println ();
  delay (1000);
}


