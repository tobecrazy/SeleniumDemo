import os,sys
import configparser

current_folder=os.getcwd()
os.chdir(current_folder+"/../config")
cf = configparser.ConfigParser()
cf.read("config")
aaa=cf.get("database", "dbname")
print(aaa)
