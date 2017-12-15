<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\HistoryNewMediaTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\HistoryNewMediaTable Test Case
 */
class HistoryNewMediaTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\HistoryNewMediaTable
     */
    public $HistoryNewMedia;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.history_new_media'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('HistoryNewMedia') ? [] : ['className' => HistoryNewMediaTable::class];
        $this->HistoryNewMedia = TableRegistry::get('HistoryNewMedia', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->HistoryNewMedia);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
