<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\HistoryNewBirdsTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\HistoryNewBirdsTable Test Case
 */
class HistoryNewBirdsTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\HistoryNewBirdsTable
     */
    public $HistoryNewBirds;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.history_new_birds'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('HistoryNewBirds') ? [] : ['className' => HistoryNewBirdsTable::class];
        $this->HistoryNewBirds = TableRegistry::get('HistoryNewBirds', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->HistoryNewBirds);

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
