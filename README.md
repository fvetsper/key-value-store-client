# key-value-store-client

### Installation

```sh
mvn clean install
```

### Usage

```sh
usage: java -jar client-jar-with-dependencies.jar <host> <port> <action> <params>
 -g,--get <K>                    gets a list by its key K.
 -gak,--get-all-keys <pattern>   returns all keys matching pattern.
 -la,--left-add <K> <V>          adds a value V to key K, from the left.
 -ra,--right-add <K> <V>         adds a value V to key K, from the right.
 -s,--set <K> <V1> <V2> <...>    set a list V1, V2,... by its key K.
```

### Usage Examples

to get a list for key 123 :
```sh
java -jar client-jar-with-dependencies.jar localhost 1234 -g 123
```

to set a list val1, val2 by key 123 :

```sh
java -jar client-jar-with-dependencies.jar localhost 1234 -s 123 val1 val2
```

to adds a value val3 to key 123, from the left :

```sh
java -jar client-jar-with-dependencies.jar localhost 1234 -la 123 val3
```


