import re
import os

oriName = []
chgName = []

oriName = os.listdir(os.getcwd())
oriName.remove("nameChanger.py")



print("you have: ori:")
print(oriName)

for i in range(len(oriName)):
	# 重命名
	os.rename(oriName[i], "img" + str(i) + ".jpg");

print("ok")