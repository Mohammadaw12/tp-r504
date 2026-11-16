#!/bin/bash

echo "Arrêt des conteneurs..."

sudo docker stop nginx-lb
sudo docker stop nginx1
sudo docker stop nginx2

echo "Suppression du réseau tplb..."

sudo docker network rm tplb

echo "Tous les conteneurs ont été arrêtés."

