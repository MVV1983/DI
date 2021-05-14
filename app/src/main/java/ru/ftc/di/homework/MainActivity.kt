package ru.ftc.di.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import ru.ftc.di.homework.presentation.MainState
import ru.ftc.di.homework.presentation.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

	//TODO: DI
	@Inject
	lateinit var viewModel : MainViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		loadButton.setOnClickListener {
			viewModel.loadStrings()
		}

		viewModel.state.observe(this) { newState ->
			renderState(newState)
		}
	}

	private fun renderState(state: MainState) {
		when (state) {
			MainState.Loading -> {
				Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
				remoteText.text = ""
				localText.text = ""
			}

			is MainState.Success -> {
				remoteText.text = state.remoteString
				localText.text = state.localString
			}
		}
	}
}