# Coding Challenges Linux command line tools - The Cut tool

## About Project
This is the fourth project in the <a href="https://codingchallenges.fyi/challenges/challenge-cut">John Crickett's coding challenges</a>.
The cut tool writes to standard output selected parts of each line of each
input file, or standard input if no files are given or for a file name.
This project was written in java employing the <a href="https://picocli.info/">picocli library for creating cli tools</a> and the 
<a href="https://www.graalvm.org/">Graavl native image</a> for creating standalone executables that doesn't require having a jvm installed.

## How to run
### Execute the standalone executable
This tool is distributed as a standalone executable created with the GraalVM Native Image. 
The Java classes were ahead-of-time (AOT) compiled into a native executable so it is not a requirement to have a 
jvm installed on your PC.

To run the tool:
Download the tool named ``cc_cut`` from the project directory and simply run
```dtd
$ ./cc_cut
```
Get the tool instructions by running `./cc_cut --help`
