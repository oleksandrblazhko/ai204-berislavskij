FROM postgres
LABEL description="Docker Image for PostgreSQL"
LABEL mainteiner="Vladislav Berislavskij"
LABEL version="1.0"

ENV POSTGRES_USER berislavskij
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DATABASE berislavskijdb

COPY ./scripts/db_script.sql /docker-entrypoint-initdb.d/

