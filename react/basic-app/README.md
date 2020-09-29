# Set Up:

## Prerequisites:
You need node.js latest version: [https://nodejs.org/en/]
OR
If you like using terminal commands you can do this:

```
curl -sL https://deb.nodesource.com/setup_14.x | sudo -E bash -
```
This command enables the NodeSource repository and creates an apt sources repository needed to get the lastest version of node. If you want to install a different version you can change the number in setup_14.x to any version you want (for example, if you want 12.x, you change it to setup_12.x).

Once that's done you run this command:

```
sudo apt install nodejs
```

This command installs both `nodejs` and `npm` to your terminal, which will be used for initializing the frontend.
Once it's finished installing, you can verify that Node.js and npm were successfully install by printing their versions:
`node --version` and `npm --version`

## initializing the frontend
Go the root folder of the react frontend (this folder will be labeled `basic-app`), and run this command:
```
npm install
```
This will install the necessary libraries needed to get react fully set up on your desktop. 

## Steps
Run spring boot server

Then navigate to project directory 'react/basic-app' and run:
```
npm start
```
