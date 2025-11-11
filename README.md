# 🎁 Amigo Invisible — Aplicación en Java

Aplicación de consola escrita en **Java** para organizar y gestionar sorteos de *amigo invisible*.  
Permite introducir participantes, asignar regalos de forma aleatoria sin repeticiones y enviar un correo electrónico a cada persona con el resultado utilizando **Jakarta Mail**.

---

## 🧩 Características principales

- Introducción interactiva de nombres y correos de los participantes.
- Validación de correos electrónicos con expresiones regulares.
- Asignación aleatoria garantizada sin repeticiones ni autoasignaciones.
- Envío automático de correos con **Jakarta Mail**.
- Configuración segura mediante archivo `.env`.

---

## ⚙️ Requisitos

- **Java 17** o superior  
- **Maven** (para compilar el proyecto)
- Una cuenta de **Gmail** con contraseña de aplicación habilitada
- Dependencia: `jakarta.mail` y `dotenv-java`

---

## 🏗️ Instalación y ejecución

1. Clona el repositorio o descarga el proyecto:

   ```bash
   git clone https://github.com/tuusuario/AmigoInvisible.git
   cd AmigoInvisible
   ```
   
2. Crea el archivo .env en la raíz del proyecto con el siguiente contenido:
   <img width="446" height="76" alt="image" src="https://github.com/user-attachments/assets/43223031-09d7-4b6e-8987-9de5b0b274e2" />
⚠️No uses comillas ni espacios alrededor del =

3. **Compilación** y **ejecución**
   ```bash
   mvn clean package
   ```
Esto generará un archivo auto-ejecutable en la carpeta **/target**
Ejecuta mediante el comando:
   ```bash
   java -jar target/JavaEmailSender-Test-1.0-SNAPSHOT-shaded.jar
   ```

## 📧 Configuración de correo (Gmail)

Activa la verificación en dos pasos en tu cuenta de Google.

Crea una contraseña de aplicación:
https://myaccount.google.com/apppasswords

Copia la clave generada y pégala en SENDER_EMAIL_KEY dentro de tu .env.

## 🧠 Estructura del proyecto
src/
 └── main/java/org/invisibleFriend/
      ├── Main.java                 # Clase principal
      ├── EmailSender.java          # Envío de correos
      └── users/
           ├── Person.java
           ├── User.java
           └── PersonCollector.java
.env                                 # Configuración de entorno
pom.xml                              # Configuración Maven

## 🔁 Flujo del programa

1. El usuario introduce los nombres y correos.
2. Se validan las direcciones con regex.
3. Se generan emparejamientos aleatorios válidos.
4. Se envía un correo a cada participante con su destinatario.

## 🧪 Ejemplo de ejecución
Bienvenido a la aplicación de amigo invisible.

Introduce un nombre (Enter vacío para salir): Ana
Ahora introduce su correo:
ana@example.com
Introduce la persona que le tocó el año pasado (Enter vacío para salir):

Introduce otro participante (Enter vacío para salir):

Enviando correos...
Correo enviado correctamente a ana@example.com

## -Reconendaciones adicionales-
Utiliza una cuenta de gmail únicamente para el envío de correos.
Si utilizas otro proveedor SMTP, cambia las variables del .env

## 👤 Autor

**Alberto Morán Reina**
