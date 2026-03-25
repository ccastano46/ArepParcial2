FROM openjdk:21-ea

WORKDIR app/bin

ENV PORT 6001
ENV URL1 "http://98.94.75.199"
ENV PORT1 34000
ENV URL2 "http://100.55.32.126"
ENV PORT2 34001

COPY /target/classes /app/bin/classes
COPY /target/dependency /app/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","eci.arem.Proxy"]