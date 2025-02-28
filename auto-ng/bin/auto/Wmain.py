import shlex
import subprocess
import sys
import time
import fileExist
import os

target_mac = input("Hedef ağın MAC adresini giriniz: ")
own_mac = input("Kendi MAC adresinizi giriniz: ")

target_mac = shlex.quote(target_mac)
own_mac = shlex.quote(own_mac)

komut = f"aireplay-ng --fakeauth 0 -a {target_mac} -h {own_mac} wlan0mon"

if fileExist.exist == True:
    with open("output.txt", "a") as file:
        process = subprocess.Popen(komut,
                                   shell=True, stdout=file, stderr = file)
        process.wait()

    with open("output.txt","r") as file:
       data = file.read()

    print("Çıktı dosyaya kaydedildi")

else:
    komutlar = [
        "git clone https://github.com/aircrack-ng/aircrack-ng",
        "cd aircrack-ng",
        "autoreconf -i",
        "./configure --with-experimental",
        "make",
        "make install",
        "ldconfig",
    ]

    for komut in komutlar:
        os.system(komut)
        time.sleep(1)
        print("Gerekli dosyalar indirildi. Tekrar başlatılıyor...")
        time.sleep(3)
        os.execl(sys.executable, sys.executable, *sys.argv)