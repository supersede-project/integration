target=/home/stamp/Git/Supersede/integration/IF/API/eu.supersede.if.api/src/test/java/
cd second-evaluation
find . -name *.java | cpio -pdm $target
cd ../third-evaluation
find . -name *.java | cpio -pdm $target
cd ..

