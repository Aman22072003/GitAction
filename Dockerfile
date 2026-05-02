FROM maven:3.9-eclipse-temurin-17

# Install Chrome
RUN apt-get update && apt-get install -y wget unzip curl gnupg \
 && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
 && sh -c 'echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list' \
 && apt-get update \
 && apt-get install -y google-chrome-stable

WORKDIR /app

COPY . .

CMD ["mvn","test"]