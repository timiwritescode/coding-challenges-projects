#! /bin/bash
# Wrapper for the wc tool in java

valid_options=("-c" "-l" "-m" "-w")


command_line_option=$1 #option to set on what java command to run

argument_correct=false
cli_options=true

# display help
for argument in "$@"; do
  if [ "$argument" == "--help" ]; then
    cat ./help.txt
    exit 1
  fi

done

read_stdin_without_arguments() {
#  if [ -p /dev/stdin ]; then
    input=$(cat)
      echo "$input" | java -jar "$CCWC" "--direct-input" "--no-options"
#  fi

}

read_stdin_with_arguments() {

    input="$(cat)"
    echo "$input" | java -jar "$CCWC" "--direct-input" "$1"

}

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
    elif [[ $2 = "" || $2 = " "  ]] && ! [ -p /dev/stdin ]; then
        echo "Error: No file provided"
        exit 1
    else
       #    check for pipes
          if [ -p /dev/stdin ] && ! [ "$2" ]; then
            read_stdin_with_arguments "$1"
            exit 1
          fi

    fi
else
  if [ -p /dev/stdin ]; then
    read_stdin_without_arguments
    exit 1
  fi
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

if  [ "$1" != "-d" ] && ! [ -e "$path_to_file" ]; then
    echo "Error: No such file '$path_to_file'"
    exit 1
fi

# Run the java code with this things

if [ $cli_options = true ]; then
  if ! [ $2 ]; then
    read_input

  else
    java -jar "$CCWC" "--filepath" "$command_line_option" "$path_to_file"
  fi

else
    java -jar "$CCWC" "--filepath" "--no-option" "$path_to_file"
fi
