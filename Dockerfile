FROM adoptopenjdk/openjdk8:ubi
#RUN sed -i "s/archive.ubuntu./mirrors.aliyun./g" /etc/apt/sources.list
#RUN sed -i "s/deb.debian.org/mirrors.aliyun.com/g" /etc/apt/sources.list
#RUN sed -i "s/security.debian.org/mirrors.aliyun.com\/debian-security/g" /etc/apt/sources.list
#RUN sed -i "s/httpredir.debian.org/mirrors.aliyun.com\/debian-security/g" /etc/apt/sources.list
VOLUME /tmp
ADD target/auto_plan.jar /auto_plan.jar
ENV password = ""
ENV db_username=""
ENV db_password=""
ENV db_host=""
ENV db_database=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Djasypt.encryptor.password=${password}","-jar" ,"/auto_plan.jar","--spring.datasource.username=${db_username}","--spring.datasource.password=${db_password}","--spring.datasource.url=jdbc:mysql://${db_url}:3306/${db_database}?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai"]