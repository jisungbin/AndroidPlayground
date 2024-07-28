package land.sungbin.androidplayground

import android.app.Notification
import android.os.Bundle
import android.service.notification.StatusBarNotification
import android.widget.RemoteViews
import androidx.activity.ComponentActivity

class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    println("::StatusBarNotification::")
    StatusBarNotification::class.java.run {
      declaredMethods.forEach { method -> println("M[${method.name}] ${method.returnType.name}") }
      declaredFields.forEach { field -> println("F[${field.name}] ${field.type.name}") }
    }

    println()

    println("::Notification::")
    Notification::class.java.run {
      declaredMethods.forEach { method -> println("M[${method.name}] ${method.returnType.name}") }
      declaredFields.forEach { field -> println("F[${field.name}] ${field.type.name}") }
    }

    println()

    println("::Notification.Action::")
    Notification.Action::class.java.run {
      declaredMethods.forEach { method -> println("M[${method.name}] ${method.returnType.name}") }
      declaredFields.forEach { field -> println("F[${field.name}] ${field.type.name}") }
    }

    println("::RemoteViews::")
    RemoteViews::class.java.run {
      declaredMethods.forEach { method -> println("M[${method.name}] ${method.returnType.name}") }
      declaredFields.forEach { field -> println("F[${field.name}] ${field.type.name}") }
    }
  }
}
