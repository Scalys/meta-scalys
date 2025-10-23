echo Flashing the on-board QSPI...
ext4load mmc 0:1 ${load_addr} /boot/firmware.bin
sf probe
sf erase 0x0 +${filesize}
sf write ${load_addr} 0x0 ${filesize}
echo Done