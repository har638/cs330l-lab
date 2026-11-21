#!/usr/bin/env bash
# ---------------------------------------------------------------
# Pushes this folder to your GitHub repository (run in Git Bash).
#
#   bash push-to-github.sh https://github.com/your-name/cs330l-lab.git
# ---------------------------------------------------------------
set -e

REPO="$1"

if [ -z "$REPO" ]; then
  echo "Usage: bash push-to-github.sh https://github.com/your-name/cs330l-lab.git"
  exit 1
fi

if [ ! -d ".github/workflows" ]; then
  echo "ERROR: .github/workflows not found."
  echo "Run this script from INSIDE the CS330L_Android_Lab folder"
  echo "(the folder that contains Q1_KotlinBasics, Q2_Layouts, ...)."
  exit 1
fi

for d in Q1_KotlinBasics Q2_Layouts Q3_MiniCalculator Q4_ExplicitIntent Q5_ActivityLifecycle; do
  if [ ! -d "$d" ]; then
    echo "ERROR: folder $d is missing."
    exit 1
  fi
done

if [ ! -d ".git" ]; then
  echo ">> initialising repository"
  git init
  git branch -M main
fi

echo ">> adding files"
git add .

if git diff --cached --quiet; then
  echo ">> nothing new to commit (files already committed)"
else
  git commit -m "CS-330L lab"
fi

if git remote get-url origin >/dev/null 2>&1; then
  echo ">> remote origin already exists, updating its URL"
  git remote set-url origin "$REPO"
else
  git remote add origin "$REPO"
fi

echo ">> pushing to $REPO"
git push -u origin main

echo
echo "Done. Now open https://github.com -> your repository -> Actions tab."
echo "The workflow 'Build APKs' builds five APKs; download them from Artifacts."
