package br.fernando.testebottomsheetmvp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class BottomFragment : BottomSheetDialogFragment(), View.OnClickListener, DataName.View {

    private lateinit var relativeLayout: RelativeLayout
    private lateinit var btnContinue: Button
    private lateinit var edUsername: EditText
    private lateinit var presenter: Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        presenter = Presenter(this)

        relativeLayout = view.findViewById(R.id.rlBottomSheet)
        btnContinue = view.findViewById<Button>(R.id.btnContinue)
        edUsername = view.findViewById<EditText>(R.id.edUsername)
        btnContinue.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when (v) {
            btnContinue -> {
                val name = checkName(edUsername.text.toString())
                presenter.sendNameForLogin(name)
                if (presenter.toOpenCanSession()) {
                    startActivity(
                        Intent(
                            activity,
                            ItemActivity::class.java
                        ).putExtra("data", name)
                    )
                    dismiss()
                }
            }
        }
    }

    override fun checkName(name: String): String {
        if (name.trim().isNotEmpty() || name.trim().isNotBlank()) {
            return name
        } else {
            Toast.makeText(activity, "nome vazio", Toast.LENGTH_SHORT).show()
        }
        return name
    }

    override fun showMessageSuccess(message: String) {
        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_SHORT).setAnchorView(relativeLayout).show()
    }

    override fun showMessageError(message: String) {
        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_SHORT).setAnchorView(relativeLayout).show()
    }


}