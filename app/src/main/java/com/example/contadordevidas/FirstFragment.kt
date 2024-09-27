package com.example.contadordevidas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.contadordevidas.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var vidaP1 = 20;
    private var venenoP1 = 0;
    private var vidaP2 = 20;
    private var venenoP2 = 0;

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (savedInstanceState != null){
            vidaP1 = savedInstanceState.getInt("vidaP1")
            vidaP2 = savedInstanceState.getInt("vidaP2")
            venenoP1 = savedInstanceState.getInt("venenoP1")
            venenoP2 = savedInstanceState.getInt("venenoP2")

            actualizaVidaP1()
            actualizaVidaP2()
        }

        //BOTONES P1----------------------------------------------------------

        binding.btnpvp1.setOnClickListener {
            vidaP1++;
            actualizaVidaP1()
        }
        binding.btnmvp1.setOnClickListener {
            vidaP1--
            actualizaVidaP1()
        }
        binding.btnPpP1.setOnClickListener {
            venenoP1++
            actualizaVidaP1()
        }
        binding.btnPmP1.setOnClickListener {
            venenoP1--
            actualizaVidaP1()
        }
        binding.btnPasarVidaP1.setOnClickListener{
            vidaP2--
            vidaP1++
            actualizaVidaP1()
            actualizaVidaP2()
        }

        //BOTONES P2 ------------------------------------------------

        binding.btnpvp2.setOnClickListener{
            vidaP2++
            actualizaVidaP2()
        }
        binding.btnmvp2.setOnClickListener{
            vidaP2--
            actualizaVidaP2()
        }
        binding.btnPpP2.setOnClickListener{
            venenoP2++
            actualizaVidaP2()
        }
        binding.btnPmP2.setOnClickListener{
            venenoP2--
            actualizaVidaP2()
        }
        binding.btnPasaVidasP2.setOnClickListener{
            vidaP2++
            vidaP1--
            actualizaVidaP1()
            actualizaVidaP2()
        }

    }

    public override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("vidaP1", vidaP1)
        outState.putInt("vidaP2",vidaP2)
        outState.putInt("venenoP1",venenoP1)
        outState.putInt("venenop2",venenoP2)

        super.onSaveInstanceState(outState)
    }

    private fun actualizaVidaP1() {
        binding.textoP1.setText("" + vidaP1 + "/" + venenoP1)
    }
    private fun actualizaVidaP2(){
        binding.textoP2.setText(""+ vidaP2 + "/" + venenoP2)
    }
}
