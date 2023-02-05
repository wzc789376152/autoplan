FROM houwm/jdk8:arm64
#arm架构使用 houwm/jdk8:arm64
#x86架构使用 houwm/jdk8:x86-64
#RUN sed -i "s/archive.ubuntu./mirrors.aliyun./g" /etc/apt/sources.list
#RUN sed -i "s/deb.debian.org/mirrors.aliyun.com/g" /etc/apt/sources.list
#RUN sed -i "s/security.debian.org/mirrors.aliyun.com\/debian-security/g" /etc/apt/sources.list
#RUN sed -i "s/httpredir.debian.org/mirrors.aliyun.com\/debian-security/g" /etc/apt/sources.list
VOLUME /tmp
ADD ../auto_plan.jar /auto_plan.jar
ENV db_username=""
ENV db_password=""
ENV db_host=""
ENV db_database=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar" ,"/auto_plan.jar","--spring.datasource.username=${db_username}","--spring.datasource.password=${db_password}","--spring.datasource.url=jdbc:mysql://${db_host}:3306/${db_database}?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai","--spring.profiles.active=prod"]