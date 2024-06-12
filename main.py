from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
import time
exe_path = '/Users/panzhiheng1/Downloads/Computer_Science/pc/chromedriver-mac-x64_2/chromedriver'
browse = webdriver.Chrome()

browse.get("https://www.python.org")