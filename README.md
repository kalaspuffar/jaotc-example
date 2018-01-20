# Example of precompiling java code.

Compiling and running the test file without any compilation.
```
javac Test.java
java Test
```

Print when a just in time compilation happens. Will by default happen after 1500 uses of a function.
```
java -client -Xbatch -XX:+PrintCompilation Test
```

Print the just in time compilation and force the compilation to happen after 5 uses of a function. Will happen earlier than 1500.
```
java -client -Xbatch -XX:+PrintCompilation -XX:CompileCommandFile=.hotspot_compiler -XX:CompileThreshold=5 -XX:-TieredCompilation Test
```

Use just in time compilation and use the disassembler to show the generated code.
```
java -client -Xbatch -XX:+PrintCompilation -XX:CompileCommandFile=.hotspot_compiler -XX:CompileThreshold=5 -XX:-TieredCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly Test
```

Compile the test class to a ahead of time library file.
```
jaotc --output=libTest.so Test.class
```

Running ahead of time code.
```
java -XX:AOTLibrary=./libTest.so -XX:+PrintAOT Test
```