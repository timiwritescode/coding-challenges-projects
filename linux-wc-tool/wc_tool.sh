#! /bin/bash
# test arrays in ba

# check for arguments


valid_options=("-c" "-l" "-m" "-w")

command_line_option=$1 #option to set on what java command to run


argument_correct=false
cli_options=true
if [[ "${command_line_option:0:1}" == "-" ]]; then

    for option in "${valid_options[@]}"; do

        if [[ "$option" == "$command_line_option" ]]; then
            argument_correct=true
            break
        fi
    done

    if [[ $argument_correct = false ]]; then
        echo "Error: Invalid argument '$command_line_option'. Valid options are: ${valid_options[*]}"
        exit 1
    elif [[ $2 = "" || $2 = " " ]]; then
        echo "Error: No file provided"
        exit 1
    fi
else
    cli_options=false
fi

# get path to file
path_to_file=""
if [ $cli_options = true ]; then
    path_to_file=$(readlink -f "$2")
else
    path_to_file=$(readlink -f "$1")
fi

# check file exists
if ! [ -e "$path_to_file" ]; then
    echo "Error: No such file '$path_to_file'"
    exit 1
fi

echo "darn it"
# Run the java code with this things

java=/home/alterego/Documents/jdk-22.0.2/bin/java

path_to_source_file=/home/alterego/IdeaProjects/Filess/src/Main.java

if [ $cli_options = true ]; then
    $java $path_to_source_file "$command_line_option" "$path_to_file"
else
    $java $path_to_source_file "--no-option" $path_to_file
fi
