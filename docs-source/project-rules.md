# Spark project rules

## Codestyle
- Java 17 syntax
- No wildcards in `import` lines.
- Closing `{` at end of line.
- Use spaces instead of tabs.
- example: Write one space before and after brackets in the if or for command.<br>bad: `if(a==b){`<br>good: `if (a == b) {`
- Use `@Override` annotation.
- Test case class name must end with 'Test'.

## Processing a pull request from a maintainer
- Tests ok?
- Code-review by other maintainer
- Author squashes the PR into the master

## Processing a pull request from a contributor
- Tests ok?
- Code-review by one maintainer
- Maintainer squashes the PR into the master

## How to update the documentation
The Markdown source files are in folder /docs. If you create a PR update these files.

**How to release the documentation:**
The Java tool "sitegen" is used to produce HTML files in the folder /docs. Commit and push these files.
Then a Github action is triggered to publish these pages to the Github Pages based [Spark homepage](https://sparkjavateam.github.io/spark).

**How to call sitegen:**

1. Clone the [sitegen repository](https://github.com/SoltauFintel/sitegen) to your IDE.
2. Build it using `gradlew iD`.
3. Write a little batch file or shell script to call the sitegen tool.
   - /docs-source/b.bat for Windows: `<path-to-sitegen>\build\install\sitegen\bin\sitegen.bat . ../docs`
   - /docs-source/b for Mac: `<path-to-sitegen>/build/install/sitegen/bin/sitegen . ../docs`
4. After modifing a docs-source file call that script from inside the docs-source folder.

Update file 'toc' if you have added a Markdown file. The first expression is the title in quotes, then a space and after that the
filename without an extension.
