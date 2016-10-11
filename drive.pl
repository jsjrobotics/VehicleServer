if ($ARGV[0] eq 'f'){
  `echo '0' > /sys/class/gpio/gpio15/value`;
  `echo '0' > /sys/class/gpio/gpio18/value`;
  `echo '1' > /sys/class/gpio/gpio2/value`; 
  `echo '1' > /sys/class/gpio/gpio3/value`;

}
elsif ($ARGV[0] eq 'i'){
  `echo "15" > /sys/class/gpio/export`;
  `echo "18" > /sys/class/gpio/export`; 
  `echo "3" > /sys/class/gpio/export`;
  `echo "2" > /sys/class/gpio/export`;
 
  `echo "out" > /sys/class/gpio/gpio15/direction`; 
  `echo "1" > /sys/class/gpio/gpio15/value`
; 
  `echo "out" > /sys/class/gpio/gpio18/direction`; 
  `echo "1" > /sys/class/gpio/gpio18/value`;
 
  `echo "out" > /sys/class/gpio/gpio3/direction`; 
  `echo "1" > /sys/class/gpio/gpio3/value`; 

  `echo "out" > /sys/class/gpio/gpio2/direction`;
  `echo "1" > /sys/class/gpio/gpio2/value`;


}
elsif ($ARGV[0] eq 'b'){
 `echo '1' > /sys/class/gpio/gpio15/value;`;
 `echo '1' > /sys/class/gpio/gpio18/value;`;
 `echo '0' > /sys/class/gpio/gpio2/value;`;
 `echo '0' > /sys/class/gpio/gpio3/value;`;

}
elsif($ARGV[0] eq 's'){
  `echo '1' > /sys/class/gpio/gpio15/value`; 
  `echo '1' > /sys/class/gpio/gpio18/value`;
  `echo '1' > /sys/class/gpio/gpio2/value`;
  `echo '1' > /sys/class/gpio/gpio3/value`;

}
