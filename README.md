# Sistema de Pedidos para Pizzería - JSF

## Descripción del Proyecto

Este proyecto implementa una aplicación web para la gestión de pedidos de pizzas utilizando JavaServer Faces (JSF) como framework de desarrollo. La aplicación permite a los usuarios personalizar sus pizzas seleccionando diferentes tipos de masa, salsa y queso, gestionando el proceso completo desde la autenticación hasta la confirmación del pedido.

El sistema ha sido desarrollado como proyecto académico para demostrar el uso de tecnologías Java EE, incluyendo JSF 2.3, CDI (Contexts and Dependency Injection), y autenticación basada en contenedor.

## Características Principales

### Funcionalidades Implementadas

- **Autenticación de Usuarios**: Sistema de login basado en FORM authentication con soporte para páginas de error personalizadas.
- **Internacionalización**: Soporte multiidioma (Español e Inglés) mediante archivos de recursos properties.
- **Gestión de Sesiones**: Mantenimiento del estado de usuario mediante Session Scoped Beans.
- **Personalización de Pizza**: Selección interactiva de componentes (masa, salsa, queso).
- **Carrito de Compras**: Visualización de los elementos seleccionados antes de confirmar el pedido.
- **Páginas Protegidas**: Control de acceso mediante restricciones de seguridad declarativas.
- **Interfaz Responsiva**: Diseño adaptable utilizando Bootstrap 5.3.2.

### Arquitectura y Patrones

El proyecto sigue el patrón MVC (Model-View-Controller):

- **Model**: Managed Beans (`PizzaBean`, `LocaleManagerBean`) que encapsulan la lógica de negocio.
- **View**: Páginas XHTML con componentes JSF que conforman la interfaz de usuario.
- **Controller**: FacesServlet que gestiona el ciclo de vida de las peticiones JSF.

## Tecnologías Utilizadas

### Backend
- **Java EE 7** (Web Profile)
- **JSF 2.3** (JavaServer Faces)
- **CDI 1.2** (Contexts and Dependency Injection)
- **Servlet 3.1**

### Frontend
- **Facelets** (Sistema de plantillas de JSF)
- **Bootstrap 5.3.2** (Framework CSS)
- **XHTML** (Lenguaje de marcado)

### Herramientas de Desarrollo
- **Apache Ant** (Sistema de construcción)
- **NetBeans IDE** (Entorno de desarrollo)
- **GlassFish Server** (Servidor de aplicaciones Java EE)

## Estructura del Proyecto

```
PizzeriaJSF/
├── src/
│   ├── conf/
│   │   └── MANIFEST.MF
│   └── java/
│       └── com/mipizzeria/beans/
│           ├── LocaleManagerBean.java       # Gestión de idiomas
│           ├── PizzaBean.java               # Lógica principal de pedidos
│           ├── mensajes.properties          # Recursos en español
│           └── mensajes_en.properties       # Recursos en inglés
├── web/
│   ├── bienvenida.xhtml                    # Página de inicio
│   ├── login.xhtml                         # Formulario de login
│   ├── login-error.xhtml                   # Página de error de autenticación
│   ├── privado/                            # Área protegida
│   │   ├── categorias.xhtml                # Menú de categorías
│   │   ├── seleccionarMasa.xhtml           # Selección de masa
│   │   ├── seleccionarSalsa.xhtml          # Selección de salsa
│   │   ├── seleccionarQueso.xhtml          # Selección de queso
│   │   ├── carrito.xhtml                   # Resumen del pedido
│   │   ├── facturacion.xhtml               # Datos de facturación
│   │   └── confirmacion.xhtml              # Confirmación del pedido
│   └── WEB-INF/
│       ├── beans.xml                       # Configuración CDI
│       ├── faces-config.xml                # Configuración JSF
│       └── web.xml                         # Descriptor de despliegue
├── nbproject/                              # Archivos de proyecto NetBeans
└── build.xml                               # Script de construcción Ant
```

## Requisitos del Sistema

### Software Necesario

- **JDK 1.8** o superior
- **Apache Ant 1.9+** (para construcción del proyecto)
- **Servidor de Aplicaciones** compatible con Java EE 7:
  - GlassFish Server 4.1 o superior (recomendado)
  - WildFly 10+
  - Payara Server 4.1+
- **NetBeans IDE 8.2+** (opcional, para desarrollo)

### Configuración del Servidor

El servidor de aplicaciones debe tener configurado:

1. **Realm de Seguridad**: Configuración de usuarios y roles para autenticación.
2. **Rol USUARIO_REGISTRADO**: Rol necesario para acceder a las páginas protegidas.

## Instalación y Despliegue

### Opción 1: Usando NetBeans IDE

1. Abrir el proyecto en NetBeans IDE
2. Configurar el servidor GlassFish en el IDE
3. Hacer clic derecho en el proyecto y seleccionar "Run"

### Opción 2: Usando Ant desde línea de comandos

```bash
# Compilar el proyecto
ant clean build

# Desplegar en el servidor configurado
ant deploy

# O compilar y desplegar en un solo paso
ant clean build deploy
```

### Opción 3: Despliegue manual

```bash
# Generar el archivo WAR
ant dist

# El archivo WAR se generará en: dist/PizzeriaJSF.war
# Desplegar manualmente en el servidor copiando el archivo a:
# - GlassFish: glassfish/domains/domain1/autodeploy/
```

## Configuración de Usuarios

Para utilizar la aplicación, es necesario configurar usuarios en el realm del servidor:

### GlassFish Server

1. Acceder a la consola de administración: `http://localhost:4848`
2. Navegar a: Configurations > server-config > Security > Realms > file
3. Agregar usuarios con el rol `USUARIO_REGISTRADO`

### Ejemplo de Usuario

```
Usuario: admin
Contraseña: admin123
Rol: USUARIO_REGISTRADO
```

## Uso de la Aplicación

### Flujo de Trabajo

1. **Acceso Inicial**: El usuario accede a la página de bienvenida (`bienvenida.xhtml`)
2. **Cambio de Idioma**: Puede seleccionar entre Español e Inglés desde el selector superior
3. **Inicio de Pedido**: Click en el botón para comenzar, redirige a login si no está autenticado
4. **Autenticación**: Ingreso de credenciales en el formulario de login
5. **Selección de Categorías**: Acceso al menú principal con las opciones de personalización
6. **Personalización**: Selección de masa, salsa y queso según preferencias
7. **Revisión del Carrito**: Verificación de los elementos seleccionados
8. **Facturación**: Ingreso de datos de facturación
9. **Confirmación**: Confirmación final del pedido

### Páginas Públicas

- `/bienvenida.xhtml`: Página de inicio
- `/login.xhtml`: Formulario de autenticación
- `/login-error.xhtml`: Página de error de login

### Páginas Protegidas

Todas las páginas bajo `/privado/*` requieren autenticación:

- `/privado/categorias.xhtml`: Menú principal
- `/privado/seleccionarMasa.xhtml`: Selección de tipo de masa
- `/privado/seleccionarSalsa.xhtml`: Selección de tipo de salsa
- `/privado/seleccionarQueso.xhtml`: Selección de tipo de queso
- `/privado/carrito.xhtml`: Carrito de compras
- `/privado/facturacion.xhtml`: Información de facturación
- `/privado/confirmacion.xhtml`: Confirmación del pedido

## Internacionalización

El sistema soporta dos idiomas mediante archivos de recursos:

### Archivos de Recursos

- `mensajes.properties`: Textos en español (idioma por defecto)
- `mensajes_en.properties`: Textos en inglés

### Cambio de Idioma

El cambio de idioma se realiza mediante el componente `LocaleManagerBean`, que mantiene el idioma seleccionado durante toda la sesión del usuario.

## Seguridad

### Mecanismos Implementados

1. **Autenticación Declarativa**: Configurada en `web.xml` mediante FORM authentication
2. **Control de Acceso Basado en Roles**: Restricción de acceso a páginas mediante `security-constraint`
3. **Gestión de Sesiones**: Timeout de sesión configurado a 30 minutos
4. **Páginas de Error Personalizadas**: Manejo de errores de autenticación

### Configuración de Seguridad

```xml
<security-constraint>
    <web-resource-collection>
        <web-resource-name>Páginas Protegidas de la Pizzería</web-resource-name>
        <url-pattern>/privado/*</url-pattern>
    </web-resource-collection>
    <auth-constraint>
        <role-name>USUARIO_REGISTRADO</role-name>
    </auth-constraint>
</security-constraint>
```

## Componentes Principales

### LocaleManagerBean

Bean de sesión que gestiona la internacionalización de la aplicación.

**Responsabilidades**:
- Mantener el código de idioma actual (`es` o `en`)
- Gestionar el cambio de idioma mediante eventos
- Actualizar el locale del contexto de JSF

### PizzaBean

Bean de sesión que mantiene el estado del pedido del usuario.

**Responsabilidades**:
- Almacenar las selecciones de masa, salsa y queso
- Gestionar la navegación entre páginas
- Mantener el estado del carrito de compras
- Procesar la información de facturación

## Consideraciones de Desarrollo

### Buenas Prácticas Aplicadas

- **Separación de Responsabilidades**: Lógica de negocio separada de la presentación
- **Uso de CDI**: Inyección de dependencias para mejor mantenibilidad
- **Beans con Scope Apropiado**: SessionScoped para mantener estado entre peticiones
- **Internacionalización desde el Inicio**: Diseño multiidioma
- **Seguridad Declarativa**: Configuración de seguridad en descriptores XML
- **Diseño Responsivo**: Interfaz adaptable a diferentes dispositivos

### Limitaciones Conocidas

- La persistencia de pedidos no está implementada (no hay conexión a base de datos)
- El sistema de autenticación es básico, sin recuperación de contraseña
- No hay validación de métodos de pago
- No se implementa confirmación por correo electrónico

## Posibles Mejoras Futuras

### Funcionalidades Adicionales

- Integración con base de datos (JPA/Hibernate) para persistencia de pedidos
- Sistema de gestión de inventario
- Panel de administración para gestionar productos
- Sistema de notificaciones por correo electrónico
- Integración con pasarelas de pago
- Historial de pedidos por usuario
- Sistema de cupones y descuentos
- Seguimiento en tiempo real del estado del pedido

### Mejoras Técnicas

- Migración a JSF 2.3+ con soporte para Web Sockets
- Implementación de pruebas unitarias y de integración
- Uso de AJAX para mejorar la experiencia de usuario
- Implementación de validación del lado del cliente
- Sistema de logging más robusto
- Caché de sesiones para mejor rendimiento

## Problemas Comunes y Soluciones

### El servidor no inicia correctamente

**Solución**: Verificar que el puerto 8080 no esté en uso y que el JDK esté correctamente configurado.

### Error de autenticación

**Solución**: Verificar que los usuarios estén correctamente configurados en el realm del servidor con el rol `USUARIO_REGISTRADO`.

### Los cambios de idioma no se aplican

**Solución**: Verificar que los archivos `mensajes.properties` y `mensajes_en.properties` estén en el classpath correcto.

### Páginas privadas accesibles sin login

**Solución**: Verificar la configuración de seguridad en `web.xml` y reiniciar el servidor.

## Recursos Adicionales

### Documentación Oficial

- [JSF 2.3 Specification](https://javaee.github.io/javaserverfaces-spec/)
- [Java EE 7 Tutorial](https://docs.oracle.com/javaee/7/tutorial/)
- [CDI 1.2 Specification](https://docs.jboss.org/cdi/spec/1.2/cdi-spec.html)
- [Bootstrap 5 Documentation](https://getbootstrap.com/docs/5.3/)

### Tutoriales Recomendados

- [Oracle JSF Tutorial](https://docs.oracle.com/javaee/7/tutorial/jsf-intro.htm)
- [Baeldung JSF Guide](https://www.baeldung.com/jsf)
- [Java EE Security](https://javaee.github.io/tutorial/security-intro.html)

## Licencia

Este proyecto ha sido desarrollado con fines académicos y educativos.

## Autor

Proyecto desarrollado como parte del curso de Desarrollo de Aplicaciones Web con Java EE.

---