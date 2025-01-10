1.	Crear la ventana de login.

2.	Conexión a la base de datos.

3.	Mostrar datos y realizar inserciones.

4.	Registrar usuarios con validación de edad.

 Login:

•	El botón de login verifica las credenciales de usuario con la base de datos. Si son correctas, muestra un mensaje de éxito y cambia a la vista de datos.

Registro de usuario:

•	Si el usuario tiene una edad válida (mayor de 18 y hasta 40), se registra en la base de datos en la tabla UsuariosNatacion.

 Mostrar datos:

•	Al presionar Cargar Datos, se ejecuta la consulta para cargar los usuarios registrados en la tabla UsuariosNatacion, y los muestra en el JTextArea.

Para mejorar las indicaciones de la tarea y que se comprendan mejor, podemos estructurarlas de forma clara y detallada, con un enfoque más descriptivo para cada paso en el contexto de la interfaz gráfica de Java (Swing) y las interacciones con la base de datos. Aquí tienes una versión mejorada:

Pasos para Implementar la Interfaz Gráfica de Login, Registro y Gestión de Datos en Java con Base de Datos

1. Crear la ventana de login

En este primer paso, debes diseñar una interfaz gráfica con Swing que incluya los siguientes elementos esenciales:

•	Campos de texto para ingresar el nombre de usuario y la contraseña.

•	Botón de "Login" para que el usuario intente ingresar al sistema.

Instrucciones:

•	Utiliza un JTextField para el nombre de usuario y un JPasswordField para la contraseña.

•	Crea un JButton que se utilizará para verificar las credenciales del usuario.

Comportamiento esperado:

•	Cuando el usuario haga clic en el botón de Login, se debe verificar si las credenciales coinciden con los datos almacenados en la base de datos. Si la validación es exitosa, el sistema cambiará a una nueva vista donde se gestionarán los datos.

2. Conexión a la base de datos

El siguiente paso es establecer una conexión con la base de datos que almacena los usuarios y sus credenciales. Esta conexión se realiza utilizando el JDBC.

Instrucciones:

•	Usa DriverManager.getConnection() para conectarte a la base de datos.

•	Configura la URL de la base de datos, el nombre de usuario y la contraseña para acceder a la base de datos MySQL.

Comportamiento esperado:

•	Si la conexión es exitosa, podrás realizar consultas para verificar las credenciales del usuario y también insertar o mostrar datos en la base de datos.

3. Mostrar datos y realizar inserciones

Una vez conectado a la base de datos, debes ser capaz de mostrar los datos almacenados y permitir inserciones.

Mostrar datos:

•	Crea un JTextArea o un JTable donde se mostrarán los datos de los usuarios registrados en la tabla UsuariosNatacion de la base de datos.

•	Al presionar un botón de Cargar Datos, se ejecuta una consulta SELECT que extrae los datos de la base de datos y los presenta en la interfaz gráfica.

Realizar inserciones:

•	Utiliza un formulario de registro con campos de texto para ingresar el nombre y la edad de los usuarios que quieren participar en natación.

•	Al hacer clic en el botón Registrar, verifica si la edad del usuario es válida (mayor de 18 y hasta 40 años).

Comportamiento esperado:

•	Los datos extraídos de la base de datos se mostrarán en un área de texto o tabla.

•	Los nuevos registros se insertarán en la base de datos cuando la edad del usuario esté dentro del rango permitido.

4. Registrar usuarios con validación de edad

Este paso es fundamental para asegurar que solo los usuarios con una edad válida puedan ser registrados en el sistema.

Instrucciones:

•	El formulario de registro debe contar con un campo de texto para el nombre del usuario y un campo de texto para la edad.

•	Después de que el usuario ingrese los datos, al presionar el botón Registrar, se debe verificar que la edad esté en el rango permitido (18 - 40 años).

Comportamiento esperado:

•	Si la edad ingresada es válida, el sistema registrará al usuario en la base de datos, en la tabla UsuariosNatacion.

•	Si la edad no es válida, el sistema mostrará un mensaje de error indicando que la edad debe estar entre 18 y 40 años.


Resumen de Comportamiento General

•	Login: Verifica las credenciales del usuario con la base de datos. Si la validación es exitosa, cambia la vista a la pantalla de gestión de datos.

•	Registro de usuario: Solo los usuarios con edades entre 18 y 40 años pueden ser registrados en la base de datos. Se muestra un mensaje de confirmación si el registro es exitoso.

•	Mostrar datos: Al presionar el botón de Cargar Datos, se consulta la base de datos y se muestran los usuarios registrados en el área de texto o en una tabla.
