package com.example.android.distributing

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;
import kotlinx.android.synthetic.main.fragment_ppt_tab.view.*
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
//import com.example.android.distributing.PdfRendererBasicFragment

val FRAGMENT_PDF_RENDERER_BASIC = "pdf_renderer_basic"

class PptTab : Fragment() {

    var pptFragmentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        //pptFragmentView = inflater.inflate(R.layout.fragment_ppt_tab, container, false)
        pptFragmentView = inflater.inflate(R.layout.fragment_ppt_tab, container,false)
        Log.i("PptView", activity.toString())
        //activity!!.supportFragmentManager.beginTransaction()
        //    .add(R.id.container, PdfRendererBasicFragment(), FRAGMENT_PDF_RENDERER_BASIC)
        //    .commit()
        //setPDFs()
        return pptFragmentView!!
    }

    companion object {
            fun newInstance(): PptTab = PptTab()
    }

    /*fun setEachPDF(pdfViewer: PDFView?, fileID: Int) {
        pdfFile = fileID.toString()
        var pdfFilePath: String = "android.resource://" + javaClass.`package`.name + "/" + fileID
        pdfViewer!!.fromAsset(pdfFilePath).defaultPage(0)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .onPageChange(this.)
            .enableAnnotationRendering(true)
            .onLoad(this)
            .scrollHandle(DefaultScrollHandle(this.context)).load()


    }

    fun setPDFs() {
        setEachPDF(pdfViewerEnglish, R.raw.presentation_saukhyam_eng)
        setEachPDF(pdfViewerHindi, R.raw.presentation_saukhyam_hindi)
    }

    override fun loadComplete(pages: Int) {
        var metaEnglishPDF: PdfDocument.Meta = pdfViewerEnglish!!.documentMeta
        var metaHindiPDF: PdfDocument.Meta = pdfViewerHindi!!.documentMeta
        printBookmarksTree(pdfViewerEnglish!!.getTableOfContents(), "-")
        printBookmarksTree(pdfViewerHindi!!.tableOfContents, "-")
    }

    fun printBookmarksTree(tree: List<PdfDocument.Bookmark>, sep: String) {
        for (b in tree) {

            Log.e("PptTab", String.format("%s %s, p %d", sep, b.title, b.pageIdx))

            if (b.hasChildren()) {
                printBookmarksTree(b.children, "$sep-")
            }
        }
    }*/
}

