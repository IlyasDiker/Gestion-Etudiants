<h1 align="center">Gestion-Etudiants</h1>
<p align="center">
  <img src="https://i.imgur.com/coQDZic.png"><br>
  <img alt="Bitbucket open issues" src="https://img.shields.io/bitbucket/issues-raw/IlyasDiker/Gestion-Etudiants">
  <img alt="V1.0" src="https://img.shields.io/badge/Version-1.0-red">
</p>

Gestion Étudiante est une application qui permet à l'utilisateur d'ajouter des utilisateurs et leur donee des absences, et chercher les absences de l'utilisateur par mois, toutes les donnes sont stockées dans une base de donee SQLite.

### Structure Tables

###### Table my_students

| UID               | FIRSTNAME | LASTNAME | BRANCH | GROUP |
| ----------------- | --------- | -------- | ------ | ----- |
| INT AUTOINCREMENT | TEXT      | TEXT     | TEXT   | TEXT  |

###### Table absences

| AID               | #STUDENT                  | DATE |
| ----------------- | ------------------------- | ---- |
| INT AUTOINCREMENT | TEXT #'MY_STUDENTS'.'UID' | TEXT |

### Previews

<img src="https://i.imgur.com/Kkg65nC.png" style="zoom: 50%;" />

<img src="https://i.imgur.com/HzqMrIE.png" style="zoom:50%;" />

<img src="https://i.imgur.com/7WDYUkC.png" style="zoom:50%;" />

<img src="https://i.imgur.com/10ofPd9.png" style="zoom:50%;" />

Created By [Ilyas BENHSSINE](https://github.com/IlyasDiker) & [Saad Kardoudi](https://github.com/Saad-kardoudi)

Made with Love ❤.

## License

--------------------

MIT License© [Ilyas BENHSSINE](https://github.com/IlyasDiker)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
