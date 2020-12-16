# Proyecto Inventory

## Descripción del Proyecto

Creación de una aplicación cuyo objetivo será tener catalogado productos dentro de una empresa. De momento, con respecto a lo que se ha dado en clase, se ha realizado una pantalla de login, una pantalla de sign up, un dashboard el cual contiene diferentes botones para acceder a diferentes secciones de la aplicación (uno de ellos muestra un listado de cursos y los datos de cada uno de ellos) .

#### Componentes

Está compuesto por: 

- SplashActivity: es la pantalla de carga de nuestra aplicación. En ella aparece el logo y el nombre de nuestra aplicación.
- LoginActivity: pantalla de inicio de sesión. Solamente podrán inicar sesión con éxito los usuarios que se hayan registrado en la aplicación. Además, controla si un usuario al iniciar sesión no ha introducido el nombre de usuario, si la contraseña no es correcta, si no cumple con el formato correcto...
- Sign UpActivity: pantalla de registro. Podrán darse de alta cualquier persona en la aplicación. En esta pantalla controlamos que no haya ningún campo en blanco para que el usuario pueda darse de alta, que la contraseña deba cumplir el formato correcto...
- DashBoardFragment: será la pantalla principal de la aplicación donde se mostrarán una serie de ImageButton para podesplazarse a cualquier parte de la aplicación. 
- ListDependencyFragment: nos muestra la lista de dependencias en este caso una lista de cursos y si pulsamos en cada uno de ellos nos manda al EditDependencyFragment.
- EditDependencyFragment: nos muestra todos los datos del curso seleccionado en el ListDependencyFragment.

#### Aprendizaje

##### Fragmentos

Siempre se encuentran en una Activity, aunque pueda ser utilizado por más de una, y aunque tiene su propio ciclo de vida siempre depende del ciclo de vida de la Activity anfitriona. De forma que cuando la actividad esté pausada, también lo están todos sus fragmentos, y cuando la actividad se destruye, se destruyen todos sus fragmentos.



##### Componente Navigation

Es el encargado de programar las transiciones entre pantallas o fragments sin tener que encargarse el programador de realizar la tarea.

Hemos utilizado:

-NavController: es el encargado de administrar la navegación dentro de un elemento NavHost.

-Hemos agregado un fragment como destino de inicio.

-Hemos conectado destinos de un fragment a otro.

-Agregar argumentos

-Instancia de objeto NavDirections. Clases de constructor y objetos simples para la acción y los destinos de envío y recepción.

##### FrameLayout

Coloca todas las vistas que contiene una sobre otra y en el mismo orden que se añaden. Inicialmente se posicionan sobre la esquina superior izquierda del padre.

##### LinearLayout

Este diseño se utiliza cuando se desea colocar los elementos en una sola fila horizontal o vertical. Se posicionan uno a continuación de otro según el orden en el que se añaden al diseño.



##### ConstraintLayout

Este diseño evita las vistas anidadas ya que cada vista se posiciona mediante constrainsts o restricciones con respecto al padre, otra vista o la línea base de forma que la jerarquía de vistas es plana. Además, es mucho más flexible y agrega nuevas características que mejoran el rendimiento.



##### Widget

Son clases que heredan de la clase View y cada uno tiene una funcionalidad concreta. Como por ejemplo: ImageButton que lo hemos usado en el Dashboard, o chechkBox que se ha usado en la pantalla de login para que recuerde el nombre de usuario y contraseña.

##### TextInputLayout

Dota al componente EditText la funcionalidad de etiqueta flotante. Se usa por ejemplo en la pantala de login de la aplicación.

##### Adapter y Spinner

El adapter es un objeto que actúa como puente entre un objeto que herede de la clase abstracta AdapterView y los datos de esta vista. Tiene 2 funciones:

-Proporcionar los datos a la vista.

-Crear la vista para cada elemento del conjunto de datos.

Spinner es una lista desplegable para seleccionar un único elemento y es equivalente al combobox de otros entornos de desarrollo.

##### Ordenar Listados

Para ordenar el listado he usado la clase Collections y el método sort, cuyos parámetros son la lista a ordenar y una clase anónima donde ordeno los datos de la lista por el nombre.

##### RecyclerView

Nos permite mostrar un conjunto de datos en formato lista o bien en cuadrícula. Es una versión mejorada del ListView y consiste que a medida que un elemento no se ve se recicla para mostrar el siguiente elemento de la lista.

##### ActionBar, AppBar o Toolbar

El actionBar un elemento de diseño que se ubica en la parte superior de cada pantalla que generalmente es persistente en toda la aplicación. Su principal función consiste en tener un titúlo  y las acciones de la aplicación.

Con la llegada de Material Design esta barra se llamó AppBar y aparece un nuevo componente Toolbar que es más potente y flexible que AppBar.

##### Opciones de Menú

También se ha implementado que el toolbar tenga opciones de menú.

##### Modelo MVP en Inventory

Con el modelo MVP el encargado de manejar las notificaciones del modelo  de procesar los datos será la clase Presentador y la única función que tendrá la vista será representar la información que el presentador le ha proporcionado.

En el modelo MVP la entrada de datos se podruce en la vista. Además, en el modelo MVP hay una correspondencia de uno a uno entre la vista y el presentador y es la vista quien se comuna con su presentador. El presentador reacciona a los eventos de la vista y se comunicará con el interactor que obtiene los datos de la base de datos o cualquier otra fuente de datos. 

Cuando se obtienen esos datos, el interactor los envía al presentador y realizará los cambios en la interfaz del usuario.