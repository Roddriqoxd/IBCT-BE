src/
└── main/
├── java/
│   └── com/
│       └── ibct/
│           └── gestion_estudiantes/
│               ├── controller/       # Controladores REST (API pública)
│               ├── service/          # Lógica de negocio (servicios)
│               ├── repository/       # Interfaces JPA (DAO)
│               ├── entity/           # Entidades JPA (modelos de BD)
│               ├── dto/              # Objetos de transferencia de datos (opcional)
│               ├── exception/        # Clases para manejo de errores personalizados
│               ├── config/           # Configuración del proyecto (seguridad, auditoría, etc.)
│               └── GestionEstudiantesApplication.java # Clase principal
└── resources/
├── application.properties       # Configuraciones del proyecto
├── static/                      # Archivos estáticos (JS, CSS, imágenes)
├── templates/                   # Plantillas Thymeleaf (si usas vistas)
└── schema.sql / data.sql        # Scripts opcionales de BD
