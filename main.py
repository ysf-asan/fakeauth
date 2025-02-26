import os
import sys
import io

stringIO = io.StringIO
sys.stdout = stringIO

os.system('ls')

print(stringIO.getvalue())