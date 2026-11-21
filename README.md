CS-330L — Android Studio Practical Lab (Kotlin + XML)
=====================================================

Folders
-------
Q1_KotlinBasics/        Question 1 — Kotlin basics (program also in scratch/KotlinBasics.kts)
Q2_Layouts/             Question 2 — five screens, one per layout (LinearLayout, GridLayout,
                        FrameLayout, ConstraintLayout, ScrollView + LinearLayout)
Q3_MiniCalculator/      Question 3 — TextView + EditText + Button
Q4_ExplicitIntent/      Question 4 — Activity 1 -> Activity 2 with putExtra / getStringExtra
Q5_ActivityLifecycle/   Question 5 — all seven lifecycle callbacks + log on the screen
CS-330L_Steps_Guide.pdf HOW TO DO EVERYTHING, step by step  <- read this first
push-to-github.sh       one-command push to GitHub (Git Bash)
CS-330L_Lab_Report.pdf  a reference report (replace the screenshots with your own)
screenshots/            the images used in the report
.github/workflows/build-apk.yml   builds the 5 APKs on GitHub

Only Kotlin and XML are used. No Compose, no Flutter, no other UI framework.


1. Put the folders on GitHub (Git Bash)
---------------------------------------
Create an EMPTY repository on github.com (no README, no .gitignore, no licence).

Recommended - clone first, then paste the files in:

    cd /c/Users/YourName/Documents
    git clone https://github.com/<your-name>/<repo>.git
    cd <repo>

    # now copy EVERYTHING from inside CS330L_Android_Lab into this folder
    # (Explorer: View > Show > Hidden items, then Ctrl+A, Ctrl+C, Ctrl+V)

    ls -a          # .github must be there
    git status     # the project folders must be listed as untracked
    git add .
    git commit -m "CS-330L lab"
    git push

No "git init" and no "git remote add" - the clone already did that, and the branch
is already called main.

Alternative - without cloning (repository must be empty):

    cd /c/Users/YourName/Downloads/CS330L_Android_Lab
    git init
    git add .
    git commit -m "CS-330L lab"
    git branch -M main
    git remote add origin https://github.com/<your-name>/<repo>.git
    git push -u origin main

or simply:  bash push-to-github.sh https://github.com/<your-name>/<repo>.git

When Git asks for a password, paste a Personal Access Token (GitHub > Settings >
Developer settings > Personal access tokens > Tokens (classic), tick "repo").
Your normal account password does not work any more.

Tips that save time:
  * If "git status" lists nothing, the files went into a sub-folder. Move them up so
    that Q1_KotlinBasics sits directly inside the repo folder.
  * If .github is missing after the copy, the hidden folder was not copied.


2. Build
--------
Open the "Actions" tab. The workflow "Build APKs" runs by itself (or press
"Run workflow"). It builds five jobs in parallel, about 4-6 minutes.
At the bottom of the finished run, download the artifacts:
    Q1_KotlinBasics-apk, Q2_Layouts-apk, Q3_MiniCalculator-apk,
    Q4_ExplicitIntent-apk, Q5_ActivityLifecycle-apk
Each is a zip; inside is app-debug.apk — rename to Q1.apk, Q2.apk, ...


3. Install on the phone (Android 10)
------------------------------------
Copy the APK to the phone, tap it, allow "install unknown apps" for your file
manager, and if Play Protect complains choose "Install anyway" (debug builds are
not signed by Google). With a cable: adb install -r Q1.apk

All five apps have different package names, so they can all be installed together.


4. Details
----------
The step-by-step PDF explains, for every question: what to open, what to press,
what to screenshot, what to write, and how to capture the Logcat for question 5
with Shizuku (LogFox, or rish + logcat -s LifecycleDemo:D).
