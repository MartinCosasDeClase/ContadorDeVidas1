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

        //BOTONE P1----------------------------------------------------------

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

    }

    private fun actualizaVidaP1() {
        binding.textView.setText("" + vidaP1 + "/" + venenoP1)
    }
    private fun actualizaVidaP2(){
        binding.textView2.setText(""+ vidaP2 + "/" + venenoP2)
    }
}
