#sudo apt-get update



#######functions#######
install_java(){
	echo installing java
	sudo apt install openjdk-8-jre-headless
}
install_mysql(){
	echo installing mysql
	sudo apt-get install mysql-server
	sudo mysql_secure_installation
	#sudo mysql -u root
	#ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password'
}
install_maven(){
	sudo apt-get install maven
}



if type java; then
    _java=java
    echo $_java
else
    install_java
    _java=java
    echo $_java
fi

_sqld="$(which mysqld)"

if _sqlid==''; then
    install_mysql
fi

if mvn clean ;  then
	echo ok
else 
   install_maven
fi



