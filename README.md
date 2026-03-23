# SensorTempLuzUMB

Aplicación Android desarrollada en Java como parte de la Actividad 5 de
Programación para Dispositivos Móviles II — Universidad Manuela Beltrán.

## Descripción

SensorTempLuzUMB es una app nativa para Android que interactúa con dos
sensores del dispositivo en tiempo real:

- **Sensor de temperatura ambiente** (`TYPE_AMBIENT_TEMPERATURE`): muestra
  el valor en °C y cambia el color de la pantalla en 6 tonos según el rango.
- **Sensor de luz** (`TYPE_LIGHT`): muestra el valor en lux, una barra de
  progreso visual y cambia el fondo en 6 niveles de intensidad.

## Pantallas

| Pantalla | Descripción |
|---|---|
| Menú principal | Navegación entre sensores y botón de salida |
| Sensor de Temperatura | 6 colores: azul claro → azul → gris → amarillo → naranja → rojo |
| Sensor de Luz | 6 niveles: negro → gris oscuro → gris → amarillo claro → amarillo sol → blanco |

## Tecnologías

- Android Studio
- Java
- SDK mínimo: API 24 (Android 7.0)
- SensorManager / SensorEventListener

## Estructura del proyecto
```
app/src/main/
├── java/com/example/sensortempluzumb/
│   ├── MainActivity.java
│   ├── TemperaturaActivity.java
│   └── LuzActivity.java
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── activity_temperatura.xml
│   │   └── activity_luz.xml
│   └── values/
│       ├── colors.xml
│       ├── strings.xml
│       └── themes.xml
└── AndroidManifest.xml
```

## Cómo probarlo

1. Clonar el repositorio y abrirlo en Android Studio.
2. Ejecutar la app en el emulador (API 24 o superior).
3. Para simular los sensores: **ícono `...` del emulador → Virtual Sensors
   → pestaña Additional Sensors**.
4. Mover los sliders de **Ambient temperature** y **Light (lux)** para ver
   los cambios en tiempo real.

## Autor

**Nicolás Moya** — Programación para Dispositivos Móviles II  
Universidad Manuela Beltrán · 2026
