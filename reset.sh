#!/bin/bash

docker-compose down --volumes --remove-orphans
docker-compose rm -v
