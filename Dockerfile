FROM openjdk:21-ea

WORKDIR app/bin

ENV PORT 6000

COPY /target/classes /app/bin/classes
COPY /target/dependency /app/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","eci.arem.MathService"]