#!/bin/bash

# Création du réseau Docker
docker network create tplb

# Construction de l'image du load balancer
docker build -t im-nginx-lb ./tp-A

#  Création des dossiers partagés
mkdir -p shared1 shared2

# Création des fichiers HTML
echo "<h1>Hello 1</h1>" > shared1/index.html
echo "<h1>Hello 2</h1>" > shared2/index.html

# Lancement du premier serveur Nginx
docker run -d --rm \
    --name nginx1 \
    --network tplb \
    -p 81:80 \
    -v "$(pwd)/shared1:/usr/share/nginx/html" \
    nginx:latest

# Lancement du deuxième serveur Nginx
docker run -d --rm \
    --name nginx2 \
    --network tplb \
    -p 82:80 \
    -v "$(pwd)/shared2:/usr/share/nginx/html" \
    nginx:latest

#  Lancement du load balancer
docker run -d --rm \
    --name nginx-lb \
    --network tplb \
    -p 83:80 \
    im-nginx-lb

