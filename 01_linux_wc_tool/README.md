# CODING CHALLENGE 01 
## Build Linux wc COMMAND LINE TOOL 

## Intializations
### Clone repo
Git clone using
```
git clone repo
```
### Make bash script executable
```cd``` to the ```/coding_challenges/01_linux_wc_tool``` directory and type the following command
```declarative
$ chmod +x wc_tool.sh
```
to make the script executable.
### Add JRE to PATH
If you didn't set the path to the JRE upon java installation, add the JRE to ```$PATH``` in ```~/.bahsrc``` like so:
```declarative
export PATH=/path-to-your-JRE:$PATH
```

_**NB: You must have java installed on your linux**_

### Create Alias
In your terminal, enter the following command:
```
$ nano ~/.bashrc
```
The nano editor opens and at the end of the file, add the following command:
```
alias ccwc=(path_to_wc_tool.sh)
```
After saving, restart the terminal session or do 
``` declarative
$ source ~/.bashrc
```
to reflect the new changes.

### Tool help
Do ```ccwc --help``` to see the list of commands and how to use.