# 基础镜像
FROM crpi-4wkevut9i07z8euo.cn-guangzhou.personal.cr.aliyuncs.com/orcalearn/openjdk:8-jre-slim

# 作者
MAINTAINER zephyrix

# 配置
ENV PARAMS=""

# 时区
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 添加应用
ADD target/group-buy-market-app.jar /group-buy-market-app.jar

ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /group-buy-market-app.jar $PARAMS"]